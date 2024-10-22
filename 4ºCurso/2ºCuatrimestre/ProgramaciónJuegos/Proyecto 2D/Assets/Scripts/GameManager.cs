using System;
using Unity.VisualScripting;
using UnityEngine;
using UnityEngine.UI;

using TMPro;


public class GameManager : MonoBehaviour
{

    [SerializeField] private Image[] playerHearts;
    [SerializeField] private Sprite[] heartStatus;
    [SerializeField] private Image SelectedWeapon;
    public int currentHearts;
    public int hp;

    [SerializeField] private GameObject dialogBox;
    [SerializeField] private TextMeshProUGUI dialogText;

    [SerializeField] private GameObject npcdialogBox;
    [SerializeField] private TextMeshProUGUI npcdialogText;
    [SerializeField] private TextMeshProUGUI npcName;
    [SerializeField] private Image npcImage;

    [SerializeField] private static int minHaerts = 4;
    [SerializeField] private static int maxHearts = 8; 

    // Start is called before the first frame update
    void Start()
    {
        InitHearts();
        UpdatecurrentHearts();
    }

    public void InitHearts(){
        
        switch(PlayerPrefs.GetInt("Dificulad")){
            case 0:
                currentHearts=4;
                break;
            case 1:
                currentHearts=6;
                break;
            case 2:
                currentHearts=8;
                break;
        }
        hp=currentHearts*4;
    }

    public void UpdatecurrentHearts(){

        int aux = hp;

        for(int i= 0; i< maxHearts; i++){
            if(i < currentHearts){
                playerHearts[i].enabled = true;
                playerHearts[i].sprite= GetHeartStatus(aux);
                aux -= 4;
            }else{
                playerHearts[i].enabled = false;
            }
        }
    }

    private Sprite GetHeartStatus(int x){
        switch(x){

            case 1: return heartStatus[1];
            case 2: return heartStatus[2];
            case 3: return heartStatus[3];
            case >= 4: return heartStatus[4];
            default: return heartStatus[0];

        }
    }
    
    public void IncreaseMaxHp(){

        currentHearts++;
        currentHearts = Mathf.Clamp(currentHearts,minHaerts,maxHearts);
        UpdatecurrentHearts();
    }

    public void UpdateMaxHp(int x){

        hp += x;
        hp = Mathf.Clamp(hp,0,maxHearts*4);
        currentHearts = Mathf.Clamp(currentHearts,minHaerts,maxHearts);
        UpdatecurrentHearts();
    }

    public bool CanHeal(){
        return hp < currentHearts*4;
    }

    public void PutWaepons(GameObject weapon){

        if(weapon.CompareTag("Espada")){

            SelectedWeapon.sprite= weapon.GetComponent<SpriteRenderer>().sprite;
            RectTransform rt1 = SelectedWeapon.GetComponent<RectTransform>();
            rt1.localEulerAngles= new Vector3(0,0,0);
            rt1.sizeDelta = new Vector2(60, 60);

        }else if(weapon.CompareTag("Arco")){
            SelectedWeapon.sprite= weapon.GetComponent<SpriteRenderer>().sprite;
            RectTransform rt2 = SelectedWeapon.GetComponent<RectTransform>();
            rt2.localEulerAngles= new Vector3(0,0,90);
            rt2.sizeDelta = new Vector2(100, 30);
        }

    }

    public void ShowText(String text)
    {
        dialogBox.SetActive(true);
        dialogText.text = text;
        Time.timeScale=0;
    }

    public void HideText()
    {
        dialogBox.SetActive(false);
        dialogText.text = "";
        Time.timeScale=1;
    }

    public void NPCShowText(String text,string name, Sprite image)
    {
        npcdialogBox.SetActive(true);
        npcdialogText.text = text;
        npcName.text = name;
        npcImage.sprite = image;
        Time.timeScale=0;
    }

    public void NPCHideText()
    {
        npcdialogBox.SetActive(false);
        npcdialogText.text = "";
        npcName.text = "";
        npcImage.sprite = null;
        Time.timeScale=1;
    }


}
