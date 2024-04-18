package ru.trifonov.evadrone.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.trifonov.evadrone.MainActivity
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.adpter.constructor.ConstructorComponentAdapter
import ru.trifonov.evadrone.di.ConstructorService
import ru.trifonov.evadrone.dto.Component


class Constructor : Fragment() {
    private lateinit var constructorService: ConstructorService
    private lateinit var baseActivity: MainActivity
    private lateinit var mBottomSheet: LinearLayout
    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var mConstructor: ConstraintLayout
    private lateinit var mAirCrews: CardView
    private lateinit var mMotors: CardView
    private lateinit var mBody: CardView
    private lateinit var mAccumulator: CardView
    private lateinit var mMoreAttrs: CardView
    private lateinit var mDroneIcon: ImageView
    private lateinit var navBar: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.constructor_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        constructorService = ConstructorService.getInstance()
        baseActivity = requireActivity() as MainActivity
        mBottomSheet = view.findViewById(R.id.bottom_sheet)
        mConstructor = view.findViewById(R.id.constructor)
        mAirCrews = view.findViewById(R.id.airscrew)
        mMotors = view.findViewById(R.id.motors)
        mBody = view.findViewById(R.id.body)
        mAccumulator = view.findViewById(R.id.accumulator)
        mMoreAttrs = view.findViewById(R.id.more)
        mDroneIcon = view.findViewById(R.id.drone_icon)
        navBar = baseActivity.findViewById(R.id.cardNav)
        mAirCrews.setOnClickListener {
            dialogBuilder(constructorService.getAirScrews(), "Винты")
        }

        mMotors.setOnClickListener { dialogBuilder(constructorService.getMotors(), "Двигатели") }
        mBody.setOnClickListener { dialogBuilderSingleComponent(constructorService.getBody(), "Корпус")}
        mAccumulator.setOnClickListener { dialogBuilder(constructorService.getAccumulators(), "Питание") }
        mMoreAttrs.setOnClickListener { dialogBuilder(constructorService.getAttributes(), "Другое") }
        mBottomSheetBehavior =  BottomSheetBehavior.from(mBottomSheet)
        mConstructor.setPadding(0, 0, 0, 300)
        mBottomSheetBehavior.isHideable = false
        mBottomSheetBehavior.peekHeight = 300
        mBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

    }

    override fun onStart() {
        super.onStart()
        mAirCrews.post{

            mBottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
                override fun onStateChanged(bottomSheet: View, newState: Int) {}

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    mAirCrews.translationX = -mAirCrews.width * slideOffset * 1.5f
                    mMotors.translationX = - mMotors.width * slideOffset * 2f
                    mMoreAttrs.translationY = mMoreAttrs.height * slideOffset
                    mAccumulator.translationX = mAccumulator.width * slideOffset * 2f
                    mBody.translationX = mBody.width * slideOffset * 1.5f
                    mDroneIcon.translationY = -mDroneIcon.height * slideOffset * 1.5f
                    navBar.translationY = navBar.height * slideOffset * 1.5f
                }

            })
        }
    }

    private fun dialogBuilder(componentsList: List<Component>, title: String){
        val dialog = AlertDialog.Builder(requireContext()).create()

        dialog.window?.setBackgroundDrawable(getDrawable(requireContext(), R.drawable.dialog_rounded_background))
        val alertDialogView = dialog.window!!.decorView
        val dialogView = layoutInflater.inflate(R.layout.selected_components_list, null)
        dialogView.findViewById<RecyclerView>(R.id.rv).adapter = ConstructorComponentAdapter(componentsList.toMutableList())
        dialogView.findViewById<TextView>(R.id.title_type_component).text = title
        dialogView.findViewById<Button>(R.id.addBtn).setOnClickListener {
            dialog.cancel()
            findNavController().navigate(R.id.action_constructor_to_catalog)
        }
        val viewGroup = alertDialogView as ViewGroup
        viewGroup.addView(dialogView)
        dialog.show()
    }

    private fun dialogBuilderSingleComponent(component: Component?, title: String){
        val dialog = AlertDialog.Builder(requireContext()).create()

        dialog.window?.setBackgroundDrawable(getDrawable(requireContext(), R.drawable.dialog_rounded_background))
        val alertDialogView = dialog.window!!.decorView
        val dialogView = layoutInflater.inflate(R.layout.selected_components_list, null)
        dialogView.findViewById<RecyclerView>(R.id.rv).adapter = ConstructorComponentAdapter(mutableListOf<Component>().also { if (component!=null) it.add(component) }){
            if (constructorService.getBody() != null) dialogView.findViewById<Button>(R.id.addBtn).visibility = View.VISIBLE
        }
        dialogView.findViewById<TextView>(R.id.title_type_component).text = title
        if (constructorService.getBody() != null) dialogView.findViewById<Button>(R.id.addBtn).visibility = View.GONE
        dialogView.findViewById<Button>(R.id.addBtn).setOnClickListener {
            dialog.cancel()
            findNavController().navigate(R.id.action_constructor_to_catalog)
        }
        val viewGroup = alertDialogView as ViewGroup
        viewGroup.addView(dialogView)
        dialog.show()
    }

}