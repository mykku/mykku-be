package com.example.mykku.feed.domain

import com.example.mykku.board.domain.Board
import com.example.mykku.common.BaseEntity
import com.example.mykku.member.domain.Member
import jakarta.persistence.*

@Entity
class Feed(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content", nullable = false)
    var content: String,

    @Column(name = "like_count", nullable = false)
    var likeCount: Int = 0,

    @Column(name = "comment_count", nullable = false)
    var commentCount: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    val board: Board,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,

    @OneToMany(mappedBy = "feed", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var feedImages: MutableList<FeedImage> = mutableListOf(),

    @OneToMany(mappedBy = "feed", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var feedComments: MutableList<FeedComment> = mutableListOf(),

    @OneToMany(mappedBy = "feed", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var feedTags: MutableList<FeedTag> = mutableListOf(),
) : BaseEntity() {
}
