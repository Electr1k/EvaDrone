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
import ru.trifonov.evadrone.adpter.AccumulatorAdapter
import ru.trifonov.evadrone.adpter.AirScrewsAdapter
import ru.trifonov.evadrone.adpter.AttributeAdapter
import ru.trifonov.evadrone.adpter.BodyAdapter
import ru.trifonov.evadrone.adpter.MotorsAdapter
import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attrubute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Motors


class Constructor : Fragment() {

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
            dialogBuilder(AirScrewsAdapter(
                arrayListOf(
                    AirScrew(0, "Винт АФП-324", description = "", 424, 0.1f,20f),
                    AirScrew(0, "Винт АФП-324", description = "", 424, 0.1f,20f),
                )
            ), "Винты")
        }
        mMotors.setOnClickListener { dialogBuilder(MotorsAdapter(
            arrayListOf(
                Motors(0, "Привод F37-43", description = "", 424, 0.3f, 4.4f, 0.4f, 4535),
                Motors(0, "Привод F37-43", description = "", 424, 0.3f, 4.4f, 0.4f, 5435),
            )
        ), "Двигатели") }
        mBody.setOnClickListener { dialogBuilder(BodyAdapter(
            arrayListOf(
                Body(id = 0, title = "Корпус титан", description = "", 1000, 4f, "Титан", 4)
            )
        ), "Корпус")}
        mAccumulator.setOnClickListener { dialogBuilder(AccumulatorAdapter(
            arrayListOf(
                Accumulator(0, "Аккумулятор ТГА-314", description = "", 424, 1.1f, voltOut = 5.2f, amperOut = 35f)
            )
        ), "Питание") }
        mMoreAttrs.setOnClickListener { dialogBuilder(AttributeAdapter(
            arrayListOf(
                Attrubute(id = 0, title = "Камера GO PRO", "",4000, weight = 0.3f)
            )
        ), "Другое") }
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

    private fun dialogBuilder(adapter: RecyclerView.Adapter<*>, title: String){
        val dialog = AlertDialog.Builder(requireContext()).create()

        dialog.window?.setBackgroundDrawable(getDrawable(requireContext(), R.drawable.dialog_rounded_background))
        val alertDialogView = dialog.window!!.decorView
        val dialogView = layoutInflater.inflate(R.layout.selected_components_list, null)
        dialogView.findViewById<RecyclerView>(R.id.rv).adapter = adapter
        dialogView.findViewById<TextView>(R.id.title_component).text = title
        dialogView.findViewById<Button>(R.id.addBtn).setOnClickListener {
            dialog.cancel()
            findNavController().navigate(R.id.action_constructor_to_catalog)
        }
        val viewGroup = alertDialogView as ViewGroup
        viewGroup.addView(dialogView)
        dialog.show()
    }

}