using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayereMovement : MonoBehaviour
{

    public float speed = 5f;
    Vector2 direction;

    Rigidbody2D rigidbody2d;
    Animator animator;

    public GameObject[] weapons;

    bool isAttacking = false;

    GameManager gameManager;

    public GameObject arrow;

    ControlEnemyScene ControlEnemy;

    bool uncontrollable;
    bool invincibility;

    float InvincibilityTime = 0.6f;
    float blinkTime = 0.1f;

    float knockbackTIme = 0.3f;
    float knockbackStrength = 10f;

    SpriteRenderer spriteRenderer;

    private int currentWeaponIndex = 0;

    List<BasicInteraction> basicInteractionlist = new List<BasicInteraction>();

    [SerializeField] private AudioClip morir;
    [SerializeField] private AudioClip espada;
    [SerializeField] private AudioClip flecha;
    [SerializeField] private AudioClip daño;

    private void Awake() {
        transform.position = DataInstance.Instance.playerPosition;
    }

    void Start()
    {
        rigidbody2d = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        gameManager = FindObjectOfType<GameManager>();
        spriteRenderer = GetComponent<SpriteRenderer>();
        gameManager.PutWaepons(weapons[currentWeaponIndex]);
        ControlEnemy = FindObjectOfType<ControlEnemyScene>();
    }

    private void FixedUpdate()
    {

        if(!uncontrollable){
            rigidbody2d.velocity = direction * speed;

        }
        

    }

    // Update is called once per frame
    void Update()
    {

        Inputs();
        Animations();
    }

    private void Inputs()
    {

        if (isAttacking || uncontrollable) return;

        direction = new Vector2(Input.GetAxisRaw("Horizontal"), Input.GetAxisRaw("Vertical")).normalized;
        ChangeWeapons();
        if (Input.GetKeyDown(KeyCode.Mouse0))
        {

            if (basicInteractionlist != null)
            {
                Vector2 playerFacing = new Vector2(animator.GetFloat("Horizontal"), animator.GetFloat("Vertical"));
                bool interactionSuccess= false;

                foreach(BasicInteraction basicInteraction in basicInteractionlist){
                    if(interactionSuccess) return;
                    if(basicInteraction.Interaction(playerFacing,transform.position)){
                        interactionSuccess = true;
                    }
                }

                if (!interactionSuccess)
                {
                    Attack();
                }

            }
            else
            {

                Attack();
            }



        }
    }


    public void Attack()
    {
        if (weapons[currentWeaponIndex].CompareTag("Espada"))
        {
            ControladorSonido.Instance.EjecutarSonido(espada);
            animator.Play("SwordAttack");
            isAttacking = true;
            AttackAnimDirection();
        }
        if (weapons[currentWeaponIndex].CompareTag("Arco"))
        {
            ControladorSonido.Instance.EjecutarSonido(flecha);
            animator.Play("BowAttack");
            isAttacking = true;
            AttackAnimDirection();
        }
    }

    private void ChangeWeapons()
    {

        float scroll = Input.GetAxis("Mouse ScrollWheel");
        if (scroll != 0f)
        {
            if (scroll > 0f)
            {
                currentWeaponIndex = (currentWeaponIndex + 1) % weapons.Length;
            }
            else if (scroll < 0f)
            {
                currentWeaponIndex--;
                if (currentWeaponIndex < 0)
                {
                    currentWeaponIndex = weapons.Length - 1;
                }
            }
        }

        gameManager.PutWaepons(weapons[currentWeaponIndex]);

    }


    public void Shoot()
    {

        var obj = Instantiate(arrow);
        Vector2 direction = new Vector2(animator.GetFloat("Horizontal"), animator.GetFloat("Vertical"));
        obj.transform.eulerAngles = new Vector3(0, 0, Vector2.SignedAngle(new Vector2(direction.x, -direction.y), Vector2.right));
        obj.transform.position = transform.position + new Vector3(direction.x, 0, direction.y) * 0.2f;
        obj.GetComponent<Rigidbody2D>().velocity = direction * 10;

    }

    private void Animations()
    {
        if (isAttacking || uncontrollable || Time.timeScale == 0) return;
        if (direction.magnitude != 0)
        {
            animator.SetFloat("Horizontal", direction.x);
            animator.SetFloat("Vertical", direction.y);
            animator.Play("Run");
        }
        else animator.Play("Idle");
    }

    private void EndAttack()
    {
        isAttacking = false;
    }

    private void AttackAnimDirection()
    {

        direction.x = animator.GetFloat("Horizontal");
        direction.y = animator.GetFloat("Vertical");

        if (Mathf.Abs(direction.y) > Mathf.Abs(direction.x))
        {
            direction.x = 0;
        }
        else
        {
            direction.y = 0;
        }

        direction = direction.normalized;
        animator.SetFloat("Horizontal", direction.x);
        animator.SetFloat("Vertical", direction.y);

        direction = Vector2.zero;

    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Curación") && gameManager.CanHeal())
        {
            Destroy(collision.gameObject);
            gameManager.UpdateMaxHp(4);
            StartCoroutine(PickItem());
        }
        else if (collision.CompareTag("Interaction"))
        {
            basicInteractionlist.Add(collision.GetComponent<BasicInteraction>());
        }


    }

    private void OnTriggerExit2D(Collider2D collision)
    {
        if (collision.CompareTag("Interaction"))
        {
            basicInteractionlist.Remove(collision.GetComponent<BasicInteraction>());
        }
    }

    private void OnCollisionEnter2D(Collision2D collision) {
        
        if ((collision.transform.CompareTag("Enemigo")||collision.transform.CompareTag("Trampa") )&& !invincibility)
        {
            gameManager.UpdateMaxHp(-2);
            StartCoroutine(Invincibility());
            StartCoroutine(Knockback(collision.transform.position));
            ControladorSonido.Instance.EjecutarSonido(daño);
        }

    }

    private IEnumerator PickItem()
    {

        animator.Play("PickItem");
        uncontrollable = true;
        direction = rigidbody2d.velocity = Vector3.zero;
        ControlEnemy.StopAllEnemies();

        yield return new WaitForSeconds(1f);

        ControlEnemy.ActivatedAllEnemies();

        uncontrollable = false;
    }

    IEnumerator Invincibility()
    {

        invincibility = true;
        float auxtime = InvincibilityTime;
        while (auxtime > 0)
        {
            yield return new WaitForSeconds(blinkTime);
            auxtime -= blinkTime;
            spriteRenderer.enabled = !spriteRenderer.enabled;
        }
        spriteRenderer.enabled = true;
        invincibility = false;


    }

    IEnumerator Knockback(Vector3 hitPosition)
    {
        uncontrollable = true;
        direction = Vector2.zero;
        rigidbody2d.velocity = (transform.position - hitPosition).normalized * knockbackStrength;
        yield return new WaitForSeconds(knockbackTIme);
        rigidbody2d.velocity = Vector3.zero;
        yield return new WaitForSeconds(knockbackTIme);
        uncontrollable = false;

    }

}
