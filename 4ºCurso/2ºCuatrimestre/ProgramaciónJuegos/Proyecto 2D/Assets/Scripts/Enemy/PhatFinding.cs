using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Pathfinding;
using TMPro.Examples;

public class Phatfinfing : EnemyHealth
{

    public enum DIRECTION { DIRECTION_DOWN, DIRECTION_UP, DIRECTION_RIGHT, DIRECTION_LEFT }

    public Transform player;
    Transform target;
    Transform inicio;

    public float speed = 200f;
    public float nextWaypointDistance = 3f;

    Path path;
    int currentWaypoint = 0;
    bool reachedEndOfPaht = false;

    Seeker seeker;
    Rigidbody2D rd;

    Vector2 direction;

    Animator animator;

    bool volver;


    [Header("Control movimiento")]
    public Transform controladorMovimiento;
    public float distanciaLinea;
    public LayerMask capaJugador;
    public bool JugadorEnRango;
    public DIRECTION facingDirection;
    private bool detectado = false;

    public override void Start()
    {
        base.Start();
        seeker = GetComponent<Seeker>();
        animator = GetComponent<Animator>();
        inicio = GetComponent<Transform>();
        target = inicio;

        StartCoroutine(updatepath());

    }

    private void Update()
    {
        JugadorEnRango = Physics2D.Raycast(controladorMovimiento.position, FacingObject(), distanciaLinea, capaJugador);
        if (JugadorEnRango && !detectado)
        {
            detectado = true;
            ContinueBehaviour();
        }
    }

    IEnumerator updatepath()
    {
        while (true)
        {
            if (seeker.IsDone())
                seeker.StartPath(rigidBody.position, target.position, OnPathComplete);
            Animations();
            yield return new WaitForSeconds(0.5f);

        }
    }

    private Vector3 FacingObject()
    {
        switch (facingDirection)
        {
            case DIRECTION.DIRECTION_DOWN:
                return -transform.up;
            case DIRECTION.DIRECTION_UP:
                return transform.up;
            case DIRECTION.DIRECTION_RIGHT:
                return transform.right;
            case DIRECTION.DIRECTION_LEFT:
                return -transform.right;
            default: return Vector3.zero;

        }
    }

    private void OnDrawGizmos()
    {
        Gizmos.color = Color.red;
        Gizmos.DrawLine(controladorMovimiento.position, controladorMovimiento.position + FacingObject() * distanciaLinea);
    }

    void OnPathComplete(Path p)
    {
        if (!p.error)
        {
            path = p;
            currentWaypoint = 0;

        }
    }


    void FixedUpdate()
    {
        if (path == null)
            return;
        if (currentWaypoint >= path.vectorPath.Count)
        {
            rigidBody.velocity = Vector2.zero;
            return;
        }
        else
        {
            reachedEndOfPaht = false;

        }

        direction = ((Vector2)path.vectorPath[currentWaypoint] - rigidBody.position).normalized;
        Vector2 force = direction * speed;

        rigidBody.AddForce(force);

        float distance = Vector2.Distance(rigidBody.position, path.vectorPath[currentWaypoint]);

        if (distance <= nextWaypointDistance)
        {
            currentWaypoint++;
        }

    }

    private void Animations()
    {
        if (rigidBody.velocity != Vector2.zero)
        {
            animator.SetFloat("Horizontal", direction.x);
            animator.SetFloat("Vertical", direction.y);
            animator.Play("Run");

        }
        else animator.Play("Idle");

    }

    public override void StopBehaviour()
    {

        Debug.Log("entra");
        StopAllCoroutines();
        speed = 0;
        rigidBody.velocity = Vector2.zero;

        Animations();
    }

    public override void ContinueBehaviour()
    {
        if (detectado)
        {
            speed = 4;
            target = player;
            StartCoroutine(updatepath());
        }
    }

}
