package com.moelattar.bostatask

import com.moelattar.bostatask.domain.models.City
import com.moelattar.bostatask.domain.usecases.remote.GetAllCitiesFromRemoteUC
import com.moelattar.bostatask.presentation.viewmodel.CitiesContract
import com.moelattar.bostatask.presentation.viewmodel.CitiesViewModel
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class CitiesViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: CitiesViewModel
    private val getAllCitiesFromRemoteUC: GetAllCitiesFromRemoteUC = mockk(relaxed = true)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = CitiesViewModel(getAllCitiesFromRemoteUC)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `filterCitiesByNameshouldcorrectlyfiltercities`() = runTest {
        // Given
        val cities = listOf(
            City(
                "Cairo",
                "",
                "12",
                emptyList(),
                dropOffAvailability = false,
                pickupAvailability = false,
                "name"
            ), City(
                "Cairo",
                "",
                "12",
                emptyList(),
                dropOffAvailability = false,
                pickupAvailability = false,
                "name"
            )
        )
        viewModel.setState(viewModel.oldViewState.copy(cities = cities))

        // When
        viewModel.onActionTrigger(CitiesContract.CitiesActions.FilterCitiesByName("Ca"))

        // Then
        TestCase.assertEquals(1, viewModel.oldViewState.cities.size)
        TestCase.assertEquals("Cairo", viewModel.oldViewState.cities.first().cityName)
    }

    @Test
    fun `setLoading should update loading state`() = runTest {
        // When
        viewModel.onActionTrigger(CitiesContract.CitiesActions.SetLoading(true))

        // Then
        TestCase.assertEquals(true, viewModel.oldViewState.isLoading)
    }

    @Test
    fun `onQueryChange should update query state`() = runTest {
        // When
        viewModel.onActionTrigger(CitiesContract.CitiesActions.OnQueryChange("search"))

        // Then
        TestCase.assertEquals("search", viewModel.oldViewState.query)
    }

    @Test
    fun `clearState should reset to initial state`() = runTest {
        // Given
        viewModel.setState(viewModel.oldViewState.copy(query = "test", isLoading = true))

        // When
        viewModel.clearState()

        // Then
        TestCase.assertEquals(CitiesContract.CitiesState.initial(), viewModel.oldViewState)
    }
}