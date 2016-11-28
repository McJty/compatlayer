package mcjty.lib.tools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.fixes.EntityId;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;

public class EntityTools {

    private static final EntityId FIXER = new EntityId();

    /**
     * This method attempts to fix an old-style (1.10.2) entity Id and convert it to the
     * string representation of the new ResourceLocation. The 1.10 version of this function will just return
     * the given id
     * This does not work for modded entities.
     * @param id an old-style entity id as used in 1.10
     * @return
     */
    public static String fixEntityId(String id) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("id", id);
        nbt = FIXER.fixTagCompound(nbt);
        return nbt.getString("id");
    }

    public static String findEntityNameByClass(Class<? extends EntityLiving> clazz) {
        ResourceLocation key = EntityList.getKey(clazz);
        return key == null ? null : key.toString();
    }

    public static Class<? extends Entity> findClassByName(String name) {
        EntityEntry entry = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(name));
        return entry == null ? null : entry.getEntityClass();
    }


    public static EntityLiving createEntity(World world, String mobId) {
        Class<? extends Entity> clazz;
        if ("WitherSkeleton".equals(mobId)) {
            clazz = EntityWitherSkeleton.class;
        } else if ("StraySkeleton".equals(mobId)) {
            clazz = EntityStray.class;
        } else {
            clazz = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(mobId)).getEntityClass();
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
        return entityLiving;
    }

    public static String findName(Class<? extends Entity> clazz, Entity entity) {
        return EntityList.getKey(clazz).toString();
    }

    public static void registerModEntity(ResourceLocation resourceLocation, Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(resourceLocation, entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
    }

    public static void registerModEntity(ResourceLocation resourceLocation, Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary) {
        EntityRegistry.registerModEntity(resourceLocation, entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
    }
}
