package com.duenasworld.leafuno.domain.model;

/**
 * Contains the outcome of a domain assessment and its explanatory text.
 *
 * @param suitability the assessment status
 * @param explanation a human-readable explanation of the result
 */
public record AssessmentResult(Suitability suitability, String explanation) {
}
