package qingzhixing.weird_items.Particle;

import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public final class WeirdParticleHelper {
    public static void AddParticle(Random random, Vec3i pos, ParticleEffect particle, int particleCount, World world) {
        for (int i = 0; i < particleCount; i++) {
            double particle_x = pos.getX() + 0.5 + (MathHelper.nextBetween(random, -1.0F, 1.0F) - 0.5);
            double particle_y = pos.getY() + 1.2 + (MathHelper.nextBetween(random, -1.0F, 1.0F) - 0.5) * 0.2;
            double particle_z = pos.getZ() + 0.5 + (MathHelper.nextBetween(random, -1.0F, 1.0F) - 0.5);
            double vx = (MathHelper.nextBetween(random, -1.0F, 1.0F) - 0.5);
            double vy = (MathHelper.nextBetween(random, -1.0F, 1.0F) - 0.5);
            double vz = (MathHelper.nextBetween(random, -1.0F, 1.0F) - 0.5);
            world.addParticle(particle, true, particle_x, particle_y, particle_z, vx, vy, vz);
        }
    }
}
