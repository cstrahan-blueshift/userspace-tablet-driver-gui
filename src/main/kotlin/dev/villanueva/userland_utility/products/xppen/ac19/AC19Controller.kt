package dev.villanueva.userland_utility.products.xppen.ac19

import dev.villanueva.userland_utility.products.DriverCodeIDs
import dev.villanueva.userland_utility.products.MappableItem
import dev.villanueva.userland_utility.products.MappableItemType
import dev.villanueva.userland_utility.products.ProductController
import dev.villanueva.userland_utility.products.config.Configuration
import dev.villanueva.userland_utility.products.config.DeviceConfiguration

class AC19Controller : ProductController() {
    init {
        mapItems.add(MappableItem(MappableItemType.Dial, "Dial -> Left", DriverCodeIDs.REL_WHEEL.code, -1))
        mapItems.add(MappableItem(MappableItemType.Dial, "Dial -> Right", DriverCodeIDs.REL_WHEEL.code, 1))
        mapItems.add(MappableItem(MappableItemType.Button, "Dial Button", DriverCodeIDs.BTN_9.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K1", DriverCodeIDs.BTN_0.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K2", DriverCodeIDs.BTN_1.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K3", DriverCodeIDs.BTN_2.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K4", DriverCodeIDs.BTN_3.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K5", DriverCodeIDs.BTN_4.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K6", DriverCodeIDs.BTN_5.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K7", DriverCodeIDs.BTN_6.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K8", DriverCodeIDs.BTN_7.code, 0))
        mapItems.add(MappableItem(MappableItemType.Button, "K9", DriverCodeIDs.BTN_8.code, 0))
    }

    override fun updateExistingDeviceConfig(deviceConfiguration: DeviceConfiguration): Configuration {
        val existingConfig = Configuration.readConfig()
        existingConfig.deviceConfigurations[getVendorIdAsString()]!![getProductIdAsString()] = deviceConfiguration
        return existingConfig
    }

    companion object {
        private fun getProductId(): Short {
            return 513
        }

        private fun getVendorId(): Short {
            return 10429
        }

        fun getProductIdAsString(): String {
            return getProductId().toString()
        }

        fun getVendorIdAsString(): String {
            return getVendorId().toString()
        }

        fun getVendorProductString(): String {
            return "${getVendorId()}:${getProductId()}"
        }

        fun getProductName(): String {
            return "XP-Pen AC19 Shortcut Remote"
        }
    }
}