using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyHit : MonoBehaviour
{
    EnemyHealth enemyHealth;
    Animator animator;

    private void Start() {
        enemyHealth = GetComponentInParent<EnemyHealth>();
        animator = GetComponent<Animator>();
    }

    public void Defeat(AudioClip audio){
        animator.Play("Dead");
        ControladorSonido.Instance.EjecutarSonido(audio);

    }

    private void Hide(){
        enemyHealth.HideENnemy();
    }
    private void Desttroy(){

        Destroy(enemyHealth.gameObject);

    }

}
