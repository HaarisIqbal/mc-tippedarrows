package com.haarisiqbal.tippedarrows.listeners;

import java.util.Random;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Listeners implements Listener {
  
  Random rand = new Random();
  boolean otherMob = true; // to run code only when it is skeleton and not other entity.
  
  @EventHandler
  public void skelShot(EntityShootBowEvent shootEvent) {
    
    EntityType e = shootEvent.getEntityType();
    
    if (e == EntityType.SKELETON) {
      otherMob = false;
    }
    
  }
  
  @EventHandler
  public void arrHit(ProjectileHitEvent hitEvent) {
    
    if (otherMob) {
      return;
    }
    
    int ticks = 200; // 20 ticks = 1 Second.
    PotionEffect p = new PotionEffect(PotionEffectType.HEAL, ticks, 1);
    
    switch(rand.nextInt(5)) {
      case 0:
        p = new PotionEffect(PotionEffectType.HUNGER, ticks, 1);
        break;
      case 1:
        p = new PotionEffect(PotionEffectType.BLINDNESS, ticks, 1);
        break;
      case 2:
        p = new PotionEffect(PotionEffectType.POISON, ticks, 1);
        break;
      case 3:
        p = new PotionEffect(PotionEffectType.LEVITATION, ticks/2, 1);
        break;
      case 4:
        p = new PotionEffect(PotionEffectType.CONFUSION, ticks, 1);
        break;
      default:
        break;
    }
    
    Entity e = hitEvent.getHitEntity();
    
    if (e != null) { // bug fix, ensuring living entity.
      LivingEntity l = (LivingEntity) hitEvent.getHitEntity();
      l.addPotionEffect(p);
    }
    
    otherMob = true;
    
  }
  
}
