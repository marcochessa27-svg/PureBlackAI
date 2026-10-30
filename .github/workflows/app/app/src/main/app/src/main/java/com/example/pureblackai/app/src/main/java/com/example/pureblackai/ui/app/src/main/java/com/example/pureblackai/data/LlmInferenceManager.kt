package com.example.pureblackai.data

import android.content.Context
import com.google.mediapipe.tasks.genai.llminference.LlmInference
import java.io.File

class LlmInferenceManager(private val context: Context) {
    private var llmInference: LlmInference? = null

        fun initModel(modelFileName: String = "qwen2.5-1.5b-instruct.task") {
                val modelFile = File(context.filesDir, modelFileName)
                        if (modelFile.exists()) {
                                    val options = LlmInference.LlmInferenceOptions.builder()
                                                    .setModelPath(modelFile.absolutePath)
                                                                    .setMaxTokens(1024)
                                                                                    .build()
                                                                                                llmInference = LlmInference.createFromOptions(context, options)
                                                                                                        }
                                                                                                            }

                                                                                                                fun generateResponse(prompt: String): String {
                                                                                                                        return llmInference?.generateResponse(prompt) ?: "Errore: Modello non trovato o non caricato."
                                                                                                                            }
                                                                                                                            }
                                                                                                                            