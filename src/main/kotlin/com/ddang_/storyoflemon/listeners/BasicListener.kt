package com.ddang_.storyoflemon.listeners

import com.ddang_.storyoflemon.Storyoflemon
import com.ddang_.storyoflemon.utils.ComponentUtil
import com.destroystokyo.paper.event.server.PaperServerListPingEvent
import net.kyori.adventure.text.Component
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockExpEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.ExpBottleEvent
import org.bukkit.event.entity.ItemSpawnEvent
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.PlayerFishEvent

class BasicListener: Listener {

    //경험치
    @EventHandler
    fun exp1(e: BlockExpEvent){
        e.expToDrop = 0
    }

    @EventHandler
    fun exp2(e: EntityDeathEvent){
        e.droppedExp = 0
    }

    @EventHandler
    fun exp3(e: ExpBottleEvent){
        e.experience = 0
    }

    @EventHandler
    fun exp4(e: PlayerFishEvent){
        e.expToDrop = 0
    }

    //조합
    @EventHandler
    fun onCraft(e: CraftItemEvent) {
        e.isCancelled = true
    }


    //아이템 이름
    @EventHandler
    fun itemSpawn(e: ItemSpawnEvent) {
        val item = e.entity
        item.isCustomNameVisible = true
    }

    //핑
    @EventHandler
    fun ping(e: PaperServerListPingEvent){
        e.version = "1.19 Story of Lemon"
        e.motd(
            Component.text().append(
                ComponentUtil.toText("          Project", "f9f47e"),
                ComponentUtil.toText(" 레몬 이야기", "f6f438"),
                ComponentUtil.toText(" -", "cdcc60"),
                ComponentUtil.toText(" ${Storyoflemon.instance.description.version}", "fef9b2"),
                Component.newline(),
                ComponentUtil.toText("             #1.19 #스토리 #퍼즐 #협동 #탈출맵", "ffffff")
            ).build()
        )
    }
}