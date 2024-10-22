using System.Collections;
using UnityEngine;

public class EnemyHealth : MonoBehaviour
{

    [Header("EnemyHP parameters")]

    public int maxHp = 5;
    public int hp = 5;

    protected bool invincibility;
    protected float InvincibilityTime = 0.6f;
    protected float blinkTime = 0.1f;

    protected float knockbackTIme = 0.3f;
    protected float knockbackStrength = 0f;

    protected Rigidbody2D rigidBody;
    protected SpriteRenderer spriteRenderer;
    protected EnemyHit enemyHit;
    
    [SerializeField] private AudioClip morir;
    

    public virtual void Start()
    {

        spriteRenderer = GetComponent<SpriteRenderer>();
        enemyHit = GetComponentInChildren<EnemyHit>();
        rigidBody = GetComponent<Rigidbody2D>();
        
        hp = maxHp;
    }


    private void OnTriggerEnter2D(Collider2D colllision)
    {

        if (!invincibility)
        {

            if (colllision.CompareTag("Espada"))
            {
                hp--;
                if (hp <= 0)
                {
                    enemyHit.Defeat(morir);
                }
                StopBehaviour();
                StartCoroutine(Invincibility());
                knockbackStrength = 2f;
                StartCoroutine(Knockback(colllision.transform.position));
            }
            else if (colllision.CompareTag("Flecha"))
            {
                hp--;
                if (hp <= 0)
                {
                    enemyHit.Defeat(morir);
                }
                StopBehaviour();
                StartCoroutine(Invincibility());
                knockbackStrength = 0f;
                StartCoroutine(Knockback(colllision.transform.position));
            }
        }

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

        if (knockbackStrength <= 0)
        {
            if (hp > 0)
                ContinueBehaviour();
            yield break;
        }
        rigidBody.velocity = (transform.position - hitPosition).normalized * knockbackStrength;
        yield return new WaitForSeconds(knockbackTIme);
        rigidBody.velocity = Vector3.zero;
        yield return new WaitForSeconds(knockbackTIme);
        if (hp > 0)
            ContinueBehaviour();

    }

    public void HideENnemy()
    {
        StopAllCoroutines();
        rigidBody.velocity = Vector3.zero;
        spriteRenderer.enabled = false;
    }

    public virtual void StopBehaviour()
    {

    }

    public virtual void ContinueBehaviour()
    {

    }
}
