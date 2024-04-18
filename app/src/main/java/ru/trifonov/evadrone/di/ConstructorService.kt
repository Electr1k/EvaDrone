package ru.trifonov.evadrone.di

import android.annotation.SuppressLint
import android.content.Context
import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attribute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Motor

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



}