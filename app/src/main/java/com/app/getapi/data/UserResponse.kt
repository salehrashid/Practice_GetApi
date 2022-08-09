package com.app.getapi.data

import com.google.gson.annotations.SerializedName

data class UserResponse(
	@field:SerializedName("UserItem")
	val userResponse: List<UserItem?>? = null
)
