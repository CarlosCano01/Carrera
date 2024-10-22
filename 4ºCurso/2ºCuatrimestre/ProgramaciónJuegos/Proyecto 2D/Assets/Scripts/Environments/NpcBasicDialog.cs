using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NpcBasicDialog : BasicInteraction
{
    public string[] dialog;
    public string Npcname;
    public Sprite image;
    int dialogcounter;
    GameManager gameManager;
    NPCrandomPatrol nPCrandomPatrol;

    private void Start() {
        gameManager= FindObjectOfType<GameManager>();
        nPCrandomPatrol = GetComponent<NPCrandomPatrol>();
    }

    public override bool Interaction(Vector2 playerFacing, Vector2 playerPos)
    {   
        bool success= FacingNPC(playerFacing, playerPos, transform.position);

        if(success) {
            nPCrandomPatrol.FacePlayer(playerPos);
            NextDialog();}
        else EndDialog();


        return success;
    }

    private void NextDialog(){
        if(dialogcounter == dialog.Length){
            EndDialog();
        }else{
            gameManager.NPCShowText(dialog[dialogcounter],name,image);
            dialogcounter++;
        }
    }

    private void EndDialog(){
        gameManager.NPCHideText();
        dialogcounter=0;
    }
}
