package mcjty.lib.tools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.lang.reflect.InvocationTargetException;

public class EntityTools {

    public static String findEntityNameByClass(Class<? extends EntityLiving> clazz) {
        return EntityList.CLASS_TO_NAME.get(clazz);
    }

    public static Class<? extends Entity> findClassByName(String name) {
        return EntityList.NAME_TO_CLASS.get(name);
    }

    public static EntityLiving createEntity(World world, String mobId) {
        Class<? extends Entity> clazz;
        if ("WitherSkeleton".equals(mobId)) {
            clazz = EntitySkeleton.class;
        } else if ("StraySkeleton".equals(mobId)) {
            clazz = EntitySkeleton.class;
        } else {
            clazz = findClassByName(mobId);
        }
        EntityLiving entityLiving = null;
        try {
            entityLiving = (EntityLiving) clazz.getConstructor(World.class).newInstance(world);
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        }
        if ("WitherSkeleton".equals(mobId)) {
            ((EntitySkeleton) entityLiving).setSkeletonType(SkeletonType.WITHER);
        } else if ("StraySkeleton".equals(mobId)) {
            ((EntitySkeleton) entityLiving).setSkeletonType(SkeletonType.STRAY);
        } else if (entityLiving instanceof EntitySkeleton) {
            // Force non-wither otherwise
            ((EntitySkeleton) entityLiving).setSkeletonType(SkeletonType.NORMAL);
        }
        return entityLiving;
    }

    public static String findName(Class<? extends Entity> clazz, Entity entity) {
        if (entity instanceof EntitySkeleton) {
            EntitySkeleton skeleton = (EntitySkeleton) entity;
            if (skeleton.getSkeletonType() == SkeletonType.WITHER) {
                return "WitherSkeleton";
            } else if (skeleton.getSkeletonType() == SkeletonType.STRAY) {
                return "StraySkeleton";
            }
        }
        return EntityList.CLASS_TO_NAME.get(clazz);
    }


    public static void registerModEntity(ResourceLocation resourceLocation, Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
    }

    public static void registerModEntity(ResourceLocation resourceLocation, Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary) {
        EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
    }
}
