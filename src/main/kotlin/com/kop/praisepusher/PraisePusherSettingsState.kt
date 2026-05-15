package com.kop.praisepusher

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.service

@Service(Service.Level.APP)
@State(
    name = "PraisePusherSettings",
    storages = [Storage("PraisePusherSettings.xml")]
)
class PraisePusherSettingsState : PersistentStateComponent<PraisePusherSettingsState.SettingsState> {
    private var state = SettingsState()

    var displayName: String
        get() = state.displayName
        set(value) {
            state.displayName = value
        }

    override fun getState(): SettingsState = state

    override fun loadState(state: SettingsState) {
        this.state = state
    }

    data class SettingsState(
        var displayName: String = ""
    )

    companion object {
        fun getInstance(): PraisePusherSettingsState = service()
    }
}
