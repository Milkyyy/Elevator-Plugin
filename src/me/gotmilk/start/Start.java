package me.gotmilk.start;

import me.gotmilk.eventsa.Elevator;
import me.gotmilk.eventsa.C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Start
  extends JavaPlugin implements Listener
{
  private static Start instance;
  public static String label = C.DGray + "[" + C.Red + "!" + C.DGray + "]";
  
  public void onEnable()
  {
    instance = this;
    getServer().getPluginManager().registerEvents(new Elevator(), this);
    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Elevator v1.0 Started!" + ChatColor.DARK_GRAY + "]");
    Bukkit.getConsoleSender().sendMessage(Start.label + "Skype: gotmilkisreal");
    Bukkit.getConsoleSender().sendMessage(Start.label + "GitHub: www.github.com/Milkyyy");
    AntiLeak();
    getServer().getPluginManager().registerEvents( this, this);
  }
  
  private void AntiLeak()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          URL url = new URL("http://pastebin.com/raw/WNiKeSSm");
          HttpURLConnection conn = (HttpURLConnection)url.openConnection();
          BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
          String inputLine = in.readLine();
          Boolean run = Boolean.valueOf(inputLine);
          if (!run.booleanValue())
          {
            Bukkit.getConsoleSender().sendMessage(Start.label + C.Red + " DISABLED DUE TO LEAKS");
            Bukkit.getConsoleSender().sendMessage(Start.label + C.Red + " DISABLED DUE TO LEAKS");
            Bukkit.getConsoleSender().sendMessage(Start.label + C.Red + " DISABLED DUE TO LEAKS");
            Bukkit.getConsoleSender().sendMessage(Start.label + C.Red + " DISABLED DUE TO LEAKS");
          }
          in.close();
        }
        catch (Exception e)
        {
        }
      }
    })
    
      .start();
  }
  
  public void onDisable()
  {
    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Elevator v1.0 Disabled!" + ChatColor.DARK_GRAY + "]");
    Bukkit.getConsoleSender().sendMessage(Start.label + "Skype: gotmilkisreal");
    Bukkit.getConsoleSender().sendMessage(Start.label + "GitHub: www.github.com/Milkyyy");
    Bukkit.getConsoleSender().sendMessage(Start.label + " Disabling");
  }
  
  public static Start getInstance()
  {
    return instance;
  }
}
