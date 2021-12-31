package com.example.myrecipe.repository

import com.example.myrecipe.domain.model.Recipe
import com.example.myrecipe.network.RecipeRetrofitService
import com.example.myrecipe.network.model.RecipeDtoMapper

class RecipeRepository_Impl(
    private val recipeRetrofitService: RecipeRetrofitService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        val result = recipeRetrofitService.search(token, page, query).recipes
        return mapper.toDomainList(result)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        val result = recipeRetrofitService.get(token, id)
        return mapper.mapToDomainModel(result)
    }

}