package fr.gonz.cosmetics.models.pets;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

public class BabyZombie extends EntityZombieHusk {
    public BabyZombie(Location loc, Player player) {
        super(EntityTypes.HUSK, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setBaby(true);

        this.setInvulnerable(true);
    }

    @Override
    public void initPathfinder() {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this,
                EntityHuman.class, 8.0F));
    }
}
