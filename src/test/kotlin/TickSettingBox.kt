import com.intellij.driver.sdk.invokeAction
import com.intellij.driver.sdk.ui.components.common.ideFrame
import com.intellij.driver.sdk.ui.components.elements.button
import com.intellij.driver.sdk.ui.components.elements.checkBoxWithName
import com.intellij.driver.sdk.ui.components.settings.settingsDialog
import com.intellij.ide.starter.driver.engine.runIdeWithDriver
import com.intellij.ide.starter.ide.IdeProductProvider
import com.intellij.ide.starter.junit5.hyphenateWithClass
import com.intellij.ide.starter.models.TestCase
import com.intellij.ide.starter.project.GitHubProject
import com.intellij.ide.starter.runner.CurrentTestMethod
import com.intellij.ide.starter.runner.Starter
import com.intellij.ide.starter.sdk.JdkDownloaderFacade.jdk21
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.time.Duration.Companion.minutes

class TickSettingBox{

    /**
     * Opens Setting -> Version Control -> ChangeLists,
     * selects the "Create changelists automatically" checkbox,
     * and verifies that it is selected.
     */
    @Test
    fun openSetting() {

        // Store configurition and GitHub repository
        val testContext = Starter
            .newContext(CurrentTestMethod.hyphenateWithClass(), TestCase(IdeProductProvider.IU, GitHubProject.fromGithub(
                branchName = "master",
                repoRelativeUrl = "Perfecto-Quantum/Quantum-Starter-Kit.git",
                commitHash = "1dc6128c115cb41fc442c088174e81f63406fad5"
            )))
            .setupSdk(jdk21.toSdk())
            .prepareProjectCleanImport()

        // Start the IDE and close it when the test is finished
        testContext.runIdeWithDriver().useDriverAndCloseIde {

            // Allows interaction with the main IDE UI
            ideFrame {
                waitForIndicators(5.minutes)

                // Open settings
                driver.invokeAction("ShowSettings")

                // Allow us to work with setting window
                settingsDialog {
                    openTreeSettingsSection("Version Control", "Changelists")

                    // Locate the checkbox
                    val checkBox = checkBoxWithName("Create changelists automatically")

                    // tick the box
                    checkBox.check()

                    // verify it is selected
                    assertTrue(checkBox.isSelected())

                    // click on OK
                    button("OK").click()
                }
            }
        }
    }
}