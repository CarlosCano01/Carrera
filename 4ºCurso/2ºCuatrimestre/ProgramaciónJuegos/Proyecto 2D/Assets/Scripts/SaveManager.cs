
using UnityEngine;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using UnityEditor;

public static class SaveManager 
{
    public static void SaveMenuData(MenuData menuData){
        string dataPath = Application.persistentDataPath  +"/player.save";
        FileStream fileStream = new FileStream(dataPath,FileMode.Create);
        BinaryFormatter binaryFormatter = new BinaryFormatter();
        binaryFormatter.Serialize(fileStream,menuData);
        fileStream.Close();
    }

    public static MenuData LoadSaveMenuData(){
        string dataPath = Application.persistentDataPath  +"/player.save";
        if(File.Exists(dataPath)){

            FileStream fileStream = new FileStream(dataPath,FileMode.Open);
            BinaryFormatter binaryFormatter = new BinaryFormatter();
            MenuData menuData = (MenuData )binaryFormatter.Deserialize(fileStream);
            fileStream.Close();
            return menuData;
        }
        else{
            Debug.Log("No se encotró nlingun archivo de guardado");
            return null;
        }
    }
}
