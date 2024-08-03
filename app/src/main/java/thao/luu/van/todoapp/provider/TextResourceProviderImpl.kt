package thao.luu.van.todoapp.provider

import android.content.Context

class TextResourceProviderImpl(
    private val context: Context
) : TextResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}