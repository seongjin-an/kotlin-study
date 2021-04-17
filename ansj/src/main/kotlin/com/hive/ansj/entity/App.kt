package com.hive.ansj.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="tbl_app", schema="public")
class App (
    @Id
    @Column(name="NO")
    var no:Int,
    @Column(name="NAME")
    var name:String
)