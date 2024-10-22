using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Sign : MonoBehaviour
{

    public string text= "";
    GameManager gameManager;

    // Start is called before the first frame update
    void Start()
    {
        gameManager= FindObjectOfType<GameManager>();
    }


    private void OnTriggerEnter2D(Collider2D collision) {
        if(collision.CompareTag("Jugador")){
            gameManager.ShowText(text);
        }
    }

    private void OnTriggerExit2D(Collider2D collision) {
        if(collision.CompareTag("Jugador")){
            gameManager.HideText();
        }
    }
}
