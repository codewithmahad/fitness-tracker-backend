-- V2__add_missing_recommendation_fields.sql
-- Adding the 'type' and 'recommendation_text' columns that the tutorial requires.

ALTER TABLE recommendations
ADD COLUMN type VARCHAR(255),
ADD COLUMN recommendation_text VARCHAR(2000);