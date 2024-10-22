using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Trap : MonoBehaviour
{
    
    private Transform parentTransform;
    public List<GameObject> trampas;
    void Start()
    {
        StartCoroutine(StartTraps(trampas));

    }
    IEnumerator StartTraps(List<GameObject> children)
    {
        for (int i = 0; i < children.Count; i += 2)
        {
            StartCoroutine(StartTrap(children[i]));
            StartCoroutine(StartTrap(children[i+1]));
            yield return new WaitForSeconds(1.3f);
        }

    }
    IEnumerator StartTrap(GameObject trap)
    {
        Animator anim= trap.GetComponent<Animator>();
        Collider2D collider= trap.GetComponent<Collider2D>();

        while (true)
        {
            anim.Play("Up");
            collider.enabled = true;
            yield return new WaitForSeconds(2f);
            anim.Play("Down");
            collider.enabled = false;
            yield return new WaitForSeconds(2f);
        }
    }

}
