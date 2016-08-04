package com.ascotrobot.kue.models.db

import com.avaje.ebean.Model
import com.ascotrobot.kue.models.dto.CreateWidgetRequest
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

/**
 * @author Michael Vaughan
 */
@Entity
class Widget(
        @Id var id: UUID?,
        var name: String?,
        var color: String?
) : Model() {

    constructor(createWidgetRequest: CreateWidgetRequest) : this(null, createWidgetRequest.name,
            createWidgetRequest.color)

}
