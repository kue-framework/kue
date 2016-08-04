package com.ascotrobot.kue.models.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Michael Vaughan
 */
data class CreateWidgetRequest(@JsonProperty("name") val name: String?, @JsonProperty("color") val color: String?)