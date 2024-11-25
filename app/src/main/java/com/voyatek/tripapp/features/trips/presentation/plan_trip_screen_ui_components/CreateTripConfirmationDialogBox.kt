
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.PlanTripUiState
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.UiEventClass


@Composable
fun CreateTripConfirmationDialogBox(
    uiEvent: (UiEventClass) -> Unit,
    planTripUiState: PlanTripUiState,

    ) {

    val scope = rememberCoroutineScope()


    Dialog(
        onDismissRequest = {
             uiEvent(UiEventClass.hideCreateTripDialogBoxVisibility)

        },
        properties = DialogProperties(
            //securePolicy = SecureFlagPolicy.SecureOn,
        )
    ) {

        Card(

            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.5f)
                .clip(shape = RoundedCornerShape(4.dp))
            ,
            shape = CardDefaults.shape

        ){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    // .background(color = Color.Red)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Create Trip?"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp, bottom = 4.dp),
                    horizontalArrangement = Arrangement.End

                ) {

                    Button(
                        onClick = {

                        },

                        ) {

                        Text(text = "No")


                    }

                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                    )

                    Button(
                        onClick = {
                            uiEvent(UiEventClass.postCreateTrip)


                        },

                        ) {

                        Text(text = "Yes")

                    }


                }
            }


        }

        }


    }


