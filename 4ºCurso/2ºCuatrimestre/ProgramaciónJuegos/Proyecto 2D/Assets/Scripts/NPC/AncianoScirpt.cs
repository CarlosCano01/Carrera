using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class AncianoScirpt : BasicInteraction
{
    public string[] dialog;
    public string[] dialog2;
    public string[] dialog3;
    public string Npcname;
    public Sprite image;
    int dialogcounter;
    GameManager gameManager;
    NPCrandomPatrol nPCrandomPatrol;
    public GameObject Puerta;
    bool puertacerrada = true;
    bool hablarconpuerta = false;

    private void Start()
    {
        gameManager = FindObjectOfType<GameManager>();
        nPCrandomPatrol = GetComponent<NPCrandomPatrol>();
    }

    public override bool Interaction(Vector2 playerFacing, Vector2 playerPos)
    {
        bool success = FacingNPC(playerFacing, playerPos, transform.position);

        if (success)
        {
            nPCrandomPatrol.FacePlayer(playerPos);
            NextDialog();
        }
        else EndDialog();


        return success;
    }

    private void NextDialog()
    {
        if (dialogcounter == dialog.Length)
        {
            EndDialog();
        }
        else
        {
            if (hablarconpuerta)
            {
                if (puertacerrada)
                {
                    puertacerrada = false;
                    dialog = dialog2;
                    Puerta.SetActive(false);
                }
                else
                    dialog = dialog3;
            }
            gameManager.NPCShowText(dialog[dialogcounter], name, image);
            dialogcounter++;
        }

    }

    public void sethablarconpuerta(bool hablarconpuerta){
        this.hablarconpuerta=hablarconpuerta;
    }
    private void EndDialog()
    {
        gameManager.NPCHideText();
        dialogcounter = 0;
    }
}
