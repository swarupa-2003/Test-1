package com.example.ecowaste

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.test1.R

class ScheduleCollectionFragment : Fragment() {

    private lateinit var editName: EditText
    private lateinit var editAddress: EditText
    private lateinit var wasteGroup: RadioGroup
    private lateinit var priorityGroup: RadioGroup
    private lateinit var doorstepSwitch: Switch
    private lateinit var btnScheduleCollection: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_schedule_collection,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        editName = view.findViewById(R.id.editName)
        editAddress = view.findViewById(R.id.editAddress)
        wasteGroup = view.findViewById(R.id.wasteGroup)
        priorityGroup = view.findViewById(R.id.priorityGroup)
        doorstepSwitch = view.findViewById(R.id.doorstepSwitch)
        btnScheduleCollection =
            view.findViewById(R.id.btnScheduleCollection)

        btnScheduleCollection.setOnClickListener {
            scheduleCollection()
        }
    }

    private fun scheduleCollection() {

        val name = editName.text.toString().trim()
        val address = editAddress.text.toString().trim()

        if (name.isEmpty()) {
            editName.error = "Enter resident name"
            editName.requestFocus()
            return
        }

        if (address.isEmpty()) {
            editAddress.error = "Enter address"
            editAddress.requestFocus()
            return
        }

        val wasteId = wasteGroup.checkedRadioButtonId

        if (wasteId == -1) {
            Toast.makeText(
                requireContext(),
                "Please select waste type",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val priorityId = priorityGroup.checkedRadioButtonId

        if (priorityId == -1) {
            Toast.makeText(
                requireContext(),
                "Please select collection priority",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val selectedWaste =
            requireView().findViewById<RadioButton>(wasteId)

        val selectedPriority =
            requireView().findViewById<RadioButton>(priorityId)

        val wasteType = selectedWaste.text.toString()
        val priority = selectedPriority.text.toString()

        val doorstep = doorstepSwitch.isChecked

        val intent = Intent(
            requireActivity(),
            CollectionConfirmationActivity::class.java
        )

        intent.putExtra("name", name)
        intent.putExtra("address", address)
        intent.putExtra("wasteType", wasteType)
        intent.putExtra("priority", priority)
        intent.putExtra("doorstep", doorstep)

        startActivity(intent)
    }
}