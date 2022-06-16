package com.ddang_.storyoflemon.managers

import com.ddang_.storyoflemon.Storyoflemon
import com.ddang_.storyoflemon.objects.Member
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File

class MemberManager {
    companion object {
        val memberList = arrayListOf<Member>()

        fun getMember(p: Player) = memberList.find { it.player == p }
        fun getMember(name: String) = memberList.find { it.player.name == name }

        fun set(p: Player) {
            val file = File(Storyoflemon.instance.dataFolder, "${File.separator}PlayerData${File.separator}${p.uniqueId}.yml")
            val userdata = YamlConfiguration.loadConfiguration(file)

            Member(p
            )

        }

        fun remove(p: Player) {

            val m = getMember(p) ?: return

            val file = File(Storyoflemon.instance.dataFolder, "${File.separator}PlayerData${File.separator}${p.uniqueId}.yml")
            val userdata = YamlConfiguration.loadConfiguration(file)

            userdata.save(file)
        }
    }
}