package com.example.mykku.member.domain

import com.example.mykku.common.BaseEntity
import com.example.mykku.dailymessage.domain.DailyMessage
import jakarta.persistence.*

@Entity
class SaveDailyMessage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daily_message_id")
    val dailyMessage: DailyMessage,
) : BaseEntity() {
}
