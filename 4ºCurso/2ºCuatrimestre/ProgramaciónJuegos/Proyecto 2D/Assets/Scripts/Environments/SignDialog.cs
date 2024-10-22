using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SignDialog : BasicInteraction
{
    public string[] dialog;
    int dialogcounter;
    GameManager gameManager;

    private void Start() {
        gameManager= FindObjectOfType<GameManager>();
    }

    public override bool Interaction(Vector2 playerFacing, Vector2 playerPos)
    {   
        bool success= FacingObject(playerFacing);

        if(success) NextDialog();
        else EndDialog();


        return success;
    }

    private void NextDialog(){
        if(dialogcounter == dialog.Length){
            EndDialog();
        }else{
            gameManager.ShowText(dialog[dialogcounter]);
            dialogcounter++;
        }
    }

    private void EndDialog(){
        gameManager.HideText();
            dialogcounter=0;
    }
}
