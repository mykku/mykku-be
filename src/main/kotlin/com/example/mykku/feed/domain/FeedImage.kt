package com.example.mykku.feed.domain

import com.example.mykku.common.BaseEntity
import jakarta.persistence.*

@Entity
class FeedImage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "url", nullable = false)
    var url: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    val feed: Feed,
) : BaseEntity() {
}
