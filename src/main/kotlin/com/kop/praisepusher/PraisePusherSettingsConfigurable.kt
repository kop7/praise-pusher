package com.kop.praisepusher

import com.intellij.openapi.options.Configurable
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class PraisePusherSettingsConfigurable : Configurable {
    private var panel: JPanel? = null
    private var nameField: JBTextField? = null

    override fun getDisplayName(): String = "Praise Pusher"

    override fun createComponent(): JComponent {
        val textField = JBTextField()
        textField.text = PraisePusherSettingsState.getInstance().displayName
        nameField = textField
        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent("Ime:", textField, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel

        return panel as JPanel
    }

    override fun isModified(): Boolean {
        val currentName = nameField?.text?.trim().orEmpty()
        val savedName = PraisePusherSettingsState.getInstance().displayName
        return currentName != savedName
    }

    override fun apply() {
        PraisePusherSettingsState.getInstance().displayName = nameField?.text?.trim().orEmpty()
    }

    override fun reset() {
        nameField?.text = PraisePusherSettingsState.getInstance().displayName
    }

    override fun disposeUIResources() {
        panel = null
        nameField = null
    }
}
