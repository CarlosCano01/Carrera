using TMPro;
using TMPro.EditorUtilities;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.Audio;

public class MenuData : MonoBehaviour
{


    [SerializeField] private Toggle pantallCompleta;
    [SerializeField] private Slider volumen;
    [SerializeField] private TMP_Dropdown dificulad;
    [SerializeField] private AudioMixer audioMixer;

    [SerializeField] private int defaultpantallCompleta=1;
    [SerializeField] private float defaultvolumen = 0;
    [SerializeField] private int defaultdificulad = 2;
    int pantcompo1;

    void Start()
    {
        LoadSettings();
    }

    private void LoadSettings()
    {


        if (PlayerPrefs.HasKey("Volumen"))
        {
            volumen.value = PlayerPrefs.GetFloat("Volumen");
        }
        else
        {
            volumen.value = defaultvolumen;
            PlayerPrefs.SetFloat("Volumen", volumen.value);
        }
        if (PlayerPrefs.HasKey("Dificulad"))
        {
            dificulad.value = PlayerPrefs.GetInt("Dificulad");
        }
        else
        {
            dificulad.value = defaultdificulad;
            PlayerPrefs.SetInt("Dificulad", dificulad.value);
        }


        if (PlayerPrefs.HasKey("PantallCompleta"))
        {
            if (PlayerPrefs.GetInt("PantallCompleta") == 1)
            {
                pantallCompleta.isOn = true;
            }
            else
            { pantallCompleta.isOn = false; }
        }
        else
        {
            pantallCompleta.isOn = true;
            PlayerPrefs.SetInt("PantallCompleta", defaultpantallCompleta);
        }


    }

    public void CambiarVolumen(float volumen){
        audioMixer.SetFloat("Volumen",volumen);
    }
    public void SetVolumen()
    {
        PlayerPrefs.SetFloat("Volumen", volumen.value);
    }
    public void SetDificultad()
    {
        PlayerPrefs.SetInt("Dificulad", dificulad.value);
       
    }
    public void SetPantallCompleta(bool pantcom)
    {
        if (pantcom)
        {
            pantcompo1 = 1;
        }
        else
        {
            pantcompo1 = 0;
        }
        PlayerPrefs.SetInt("PantallCompleta", pantcompo1);
    }

}
