 using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ControlEnemyScene : MonoBehaviour
{
    public void StopAllEnemies(){

        GameObject enemies = GameObject.Find("Enemies");

        EnemyHealth[] enemiesArray = enemies.GetComponentsInChildren<EnemyHealth>();

        foreach(EnemyHealth enemyHealth in enemiesArray){
            enemyHealth.StopBehaviour();
        }
    }

    public void ActivatedAllEnemies(){

        GameObject enemies = GameObject.Find("Enemies");

        EnemyHealth[] enemiesArray = enemies.GetComponentsInChildren<EnemyHealth>();

        foreach(EnemyHealth enemyHealth in enemiesArray){
            enemyHealth.ContinueBehaviour();
        }
    }
}
