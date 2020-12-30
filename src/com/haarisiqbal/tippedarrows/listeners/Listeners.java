package com.haarisiqbal.tippedarrows.listeners;

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
  
  @EventHandler
  public void skelShot(EntityShootBowEvent shootEvent, ProjectileHitEvent hitEvent) {
    
    EntityType e = shootEvent.getEntityType();
    
    if (e == EntityType.SKELETON) {
      arrHit(hitEvent);
    }
    
  }
  
  @EventHandler
  public void arrHit(ProjectileHitEvent hitEvent) {
    
    // 20 ticks = 1 Second
    
    PotionEffect p = new PotionEffect(PotionEffectType.BLINDNESS, 200, 1);
    
    Entity e = hitEvent.getHitEntity();
    
    if (e != null) {
      LivingEntity l = (LivingEntity) hitEvent.getHitEntity();
      l.addPotionEffect(p);
    }
    
  }
  
}
