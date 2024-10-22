using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class DataInstance : MonoBehaviour
{
    public Vector2 playerPosition;

    private static DataInstance instance;


    public static DataInstance Instance
    {


        get
        {
            if (instance == null)
            {
                GameObject go = new GameObject("DataInstance");
                instance = go.AddComponent<DataInstance>();
                DontDestroyOnLoad(go);
                Vector2 player= FindObjectOfType<PlayereMovement>().transform.position;
                instance.playerPosition = player;
            }
            return instance;
        }
    }

    private void Awake()
    {
        if (instance != null && instance != this)
        {
            Destroy(gameObject);
        }
        else
        {
            instance = this;
            DontDestroyOnLoad(gameObject);
        }
    }
}
