package com.tongchangya.abhiraza

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @Test
    fun testActivityLaunches() {
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        controller.setup()
    }
}
