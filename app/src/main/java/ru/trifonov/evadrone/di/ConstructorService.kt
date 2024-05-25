package ru.trifonov.evadrone.di

import android.annotation.SuppressLint
import android.content.Context
import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attribute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Motor
import java.util.Collections.max
import kotlin.math.max

class ConstructorService private constructor(){

    private val airScrews: MutableList<AirScrew> = mutableListOf()
    private val motors: MutableList<Motor> = mutableListOf()
    private var body: Body? = null
    private val accumulators: MutableList<Accumulator> = mutableListOf()
    private val attributes: MutableList<Attribute> = mutableListOf()

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: ConstructorService? = null

        fun getInstance(): ConstructorService {
            return instance ?: synchronized(this) {
                instance ?: ConstructorService().also { instance = it }
            }
        }
    }

    public fun addAirScrew(airScrew: AirScrew){
        airScrews.add(airScrew)
    }
    public fun getAirScrews(): MutableList<AirScrew>{
        return airScrews
    }

    public fun removeAirScrew(airScrew: AirScrew){
        airScrews.remove(airScrew)
    }

    public fun addMotor(motor: Motor){
        motors.add(motor)
    }
    public fun getMotors(): MutableList<Motor>{
        return motors
    }
    public fun removeMotor(motor: Motor){
        motors.remove(motor)
    }
    public fun addAccumulator(accumulator: Accumulator){
        accumulators.add(accumulator)
    }
    public fun getAccumulators(): MutableList<Accumulator>{
        return accumulators
    }

    public fun removeAccumulator(accumulator: Accumulator){
        accumulators.remove(accumulator)
    }
    public fun addAttribute(attribute: Attribute){
        attributes.add(attribute)
    }
    public fun getAttributes(): MutableList<Attribute>{
        return attributes
    }

    public fun removeAttribute(attribute: Attribute){
        attributes.remove(attribute)
    }
    public fun setBody(body: Body){
        this.body = body
    }
    public fun getBody(): Body?{
        return body
    }

    public fun removeBody(){
        this.body = null
    }

    public fun checkConstraints(): List<String>{
        val constraints = mutableListOf<String>()
        if (airScrews.isEmpty()) constraints.add("Винты")
        if (motors.isEmpty()) constraints.add("Двигатели")
        if (body == null) constraints.add("Корпус")
        if (accumulators.isEmpty()) constraints.add("Питание")
        return constraints
    }


    public fun getNeedAmper(): Float{
        var total = 0f
        airScrews.forEach { total += it.needAmper }
        motors.forEach { total += it.needAmper }
        attributes.forEach { total += it.needAmper }
        return total
    }

    public fun getNeedVolt(): Float{
        return max(listOf(
            if (airScrews.isNotEmpty()) airScrews.maxOf { it.needVolt } else 0f,
            if (motors.isNotEmpty()) motors.maxOf { it.needVolt } else 0f,
            if (attributes.isNotEmpty()) attributes.maxOf { it.needVolt } else 0f,
        ))
    }

    public fun getOutAmper(): Float{
        var total = 0f
        accumulators.forEach { total += it.amperOut }
        return total
    }

    public fun getOutVolt(): Float{
        var total = 0f
        accumulators.forEach { total += it.voltOut }
        return total
    }

    public fun getWeight():Float{
        var totalWeight = 0f
        airScrews.map { totalWeight += it.weight ?: 0f }
        motors.map { totalWeight += it.weight ?: 0f }
        accumulators.map { totalWeight += it.weight ?: 0f }
        attributes.map { totalWeight += it.weight ?: 0f }
        if (body != null ) totalWeight += body!!.weight ?: 0f
        return totalWeight
    }

    public fun getMaxWeight(){
        var weight = 0f
        var idx = 0
//        motors.forEach { it.speedCycle
//            * if (idx < airScrews.size) airScrews[idx++].length else {airScrews[airScrews.size].length} }
    }
    public fun isMaking(): Boolean{
        return getNeedVolt() < getOutVolt() && getNeedAmper() < getOutAmper()
    }
    public fun getErrors(): List<String> {
        val errors = mutableListOf<String>()
        if (getNeedVolt() >= getOutVolt()){
            errors.add("Недостаточное напряжение")
        }
        if (getNeedAmper() >= getOutAmper()){
            errors.add("Недостаточная сил так")
        }
        return errors
    }
    public fun getPrice(): Int{
        var totalPrice = 0
        airScrews.map { totalPrice += it.avgPrice ?: 0 }
        motors.map { totalPrice += it.avgPrice ?: 0 }
        accumulators.map { totalPrice += it.avgPrice ?: 0 }
        attributes.map { totalPrice += it.avgPrice ?: 0 }
        if (body != null ) totalPrice += body!!.avgPrice ?: 0
        return totalPrice
    }
}