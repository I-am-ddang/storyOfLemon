package com.ddang_.storyoflemon.utils

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

class ItemUtil {
    companion object {
        fun toItem(name: String,
                   hex: Int,
                   material: Material,
                   amount: Int,
                   loreLine: List<Component>,
                   cmd: Int?): ItemStack {
            val i = ItemStack(material, amount)
            val meta = i.itemMeta?.apply {
                displayName(ComponentUtil.toText(name, "$hex"))
                lore(loreLine)
                setCustomModelData(cmd)
                addItemFlags(
                    ItemFlag.HIDE_ATTRIBUTES,
                    ItemFlag.HIDE_DYE,
                    ItemFlag.HIDE_POTION_EFFECTS,
                    ItemFlag.HIDE_ENCHANTS)
            }
            i.itemMeta = meta
            return i
        }

        fun toHead(name: String,
                   hex: Int,
                   owner: Player,
                   amount: Int,
                   loreLine: List<Component>): ItemStack {
            val i = ItemStack(Material.PLAYER_HEAD, amount)
            val meta = i.itemMeta as SkullMeta
            meta.displayName(ComponentUtil.toText(name, "$hex"))
            meta.owningPlayer = owner
            meta.lore(loreLine)
            meta.addItemFlags(
                ItemFlag.HIDE_ENCHANTS)
            i.itemMeta = meta
            return i
        }
    }
}