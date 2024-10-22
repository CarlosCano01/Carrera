using System.Collections;
using System.Collections.Generic;
using TMPro;
using Unity.VisualScripting;
using UnityEditor.Experimental.GraphView;
using UnityEngine;

public class NPCrandomPatrol : MonoBehaviour
{
    [Header("RandomPatrol parameters")]
    public float speed;
    public float minPatrolTIme;
    public float maxPatrolTIme;
    public float minWaitTIme;
    public float maxWaitTime;

    Animator animator;

    Vector2 direction;
    Rigidbody2D rigid;


    public  void Start()
    {
        animator = GetComponent<Animator>();
        rigid= GetComponent<Rigidbody2D>();


        StartCoroutine(Patrol());
    }

    IEnumerator Patrol()
    {

        while (true)
        {
            direction = RandomDirection();
            Animations();
            yield return new WaitForSeconds(Random.Range(minPatrolTIme, maxPatrolTIme));

            direction = Vector2.zero;
            Animations();
            yield return new WaitForSeconds(Random.Range(minWaitTIme, maxWaitTime));
        }
    }

    private Vector2 RandomDirection()
    {

        int x = Random.Range(0, 8);
        ;
        return x switch
        {
            0 => Vector2.up,
            1 => Vector2.down,
            2 => Vector2.left,
            3 => Vector2.right,
            4 => new Vector2(1, 1),
            5 => new Vector2(1, -1),
            6 => new Vector2(-1, 1),
            _ => new Vector2(-1, -1)
        };
    }

    public void FacePlayer(Vector2 playerPos){
        float x = playerPos.x -transform.position.x;
        float y = playerPos.y -transform.position.y;

        if(Mathf.Abs(x)> Mathf.Abs(y)){
            if(x>0) direction= Vector2.right;
            else direction = Vector2.left;
        }else{
            if(y>0) direction= Vector2.up;
            else direction = Vector2.down;
        }

         
        animator.SetFloat("Horizontal", x);
        animator.SetFloat("Vertical", y);
        direction = Vector2.zero;
        Animations();

    }

    private void Animations()
    {
        if (direction.magnitude !=0)
        {
            
            animator.SetFloat("Horizontal", direction.x);
            animator.SetFloat("Vertical", direction.y);
            animator.Play("Run");

        }else animator.Play("Idle");

        rigid.velocity= direction.normalized * speed;
    }

    public void StopBehaviour()
    {
        StopAllCoroutines();
        direction = Vector2.zero;
        Animations();
    }

    public void ContinueBehaviour()
    {
        StartCoroutine(Patrol());

    }

}
