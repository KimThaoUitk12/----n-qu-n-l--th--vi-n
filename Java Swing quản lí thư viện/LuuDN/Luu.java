/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuuDN;

/**
 *
 * @author Admin
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Luu {

	public static void saveData(Object data,String path)
	{
		try
		{
			FileOutputStream fos=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static Object readData(String path)
	{
		try
		{
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			ois.close();
			fis.close();
			return data;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
