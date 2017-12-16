package mcjty.lib.integration.computers;

import li.cil.oc.api.Driver;
import li.cil.oc.api.prefab.DriverSidedTileEntity;

public class OcCompatTools {
	public static void driverAdd(DriverSidedTileEntity te) {
		Driver.add(te);
	}
}
