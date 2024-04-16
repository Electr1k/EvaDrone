package ru.trifonov.evadrone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.trifonov.evadrone.R


class Constructor : Fragment() {

    private lateinit var mBottomSheet: LinearLayout
    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var mConstructor: ConstraintLayout
    private lateinit var mAirCrews: CardView
    private lateinit var mMotors: CardView
    private lateinit var mBody: CardView
    private lateinit var mAccumulator: CardView
    private lateinit var mMoreAttrs: CardView
    private lateinit var mDroneIcon: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.constructor_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBottomSheet = view.findViewById(R.id.bottom_sheet)
        mConstructor = view.findViewById(R.id.constructor)
        mAirCrews = view.findViewById(R.id.airscrew)
        mMotors = view.findViewById(R.id.motors)
        mBody = view.findViewById(R.id.body)
        mAccumulator = view.findViewById(R.id.accumulator)
        mMoreAttrs = view.findViewById(R.id.more)
        mDroneIcon = view.findViewById(R.id.drone_icon)
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
                }

            })
        }
    }

}