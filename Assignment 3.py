
import math

def compute_HRV(interval1: float, interval2: float, interval3: float) -> float:
    """
    Computes heart rate variability (HRV).
    Parameters: 3
        interval1, interval2, interval3: three successive heartbeat intervals, in ms
    Returns:
        the heart rate variability as the standard deviation of the intervals
    """
    mean_interval = (interval1 + interval2 + interval3) / 3
    variance = ((interval1 - mean_interval) ** 2 + (interval2 - mean_interval) ** 2 + (interval3 - mean_interval) ** 2) / 3
    hrv = math.sqrt(variance)
    return hrv

def temperature_is_fever(temperature: float, site: str) -> bool:
    """
    Determines whether a given temperature and test site represents fever.
    Parameters:
        temperature: the recorded temperature in °C
        site: either "oral" or "underarm"
    Returns:
        True if an oral temp is at least 37.8°, or an underarm temp is at least 37.2°
    """
    if site == "oral" and temperature >= 37.8:
        return True
    elif site == "underarm" and temperature >= 37.2:
        return True
    else:
        return False

def has_fever() -> bool:
    """
    Asks the user for their body temperature and where it was measured, and
    returns True if they have a fever.
    """
    temperature = float(input("Enter your body temperature in °C: "))
    site = input("Was it measured orally or underarm? ").strip().lower()
    return temperature_is_fever(temperature, site)

def has_nausea() -> bool:
    """
    Asks the user if they are experiencing nausea and returns their response as a boolean.
    """
    response = input("Are you experiencing nausea? (yes/no): ").strip().lower()
    return response == "yes"

def has_low_HRV() -> bool:
    """
    Asks the user to enter three successive heartbeat intervals, in ms,
    and returns True if these intervals represent an HRV less than 50 ms.
    """
    interval1 = float(input("Enter the first heartbeat interval (ms): "))
    interval2 = float(input("Enter the second heartbeat interval (ms): "))
    interval3 = float(input("Enter the third heartbeat interval (ms): "))
    hrv = compute_HRV(interval1, interval2, interval3)
    return hrv < 50

def has_high_cortisol() -> bool:
    """
    Asks the user to enter their cortisol level and returns True if the level is above 25.0.
    """
    cortisol_level = float(input("Enter your cortisol level: "))
    return cortisol_level > 25.0

def main() -> None:
    """
    Runs the diagnostic program and prints out the final diagnosis.
    """
    fever = has_fever()
    nausea = has_nausea()
    low_hrv = has_low_HRV()
    high_cortisol = has_high_cortisol()

    print("\nDiagnosis Summary:")
    print(f"Fever: {'Yes' if fever else 'No'}")
    print(f"Nausea: {'Yes' if nausea else 'No'}")
    print(f"Low HRV: {'Yes' if low_hrv else 'No'}")
    print(f"High Cortisol: {'Yes' if high_cortisol else 'No'}")

    if fever or nausea or low_hrv or high_cortisol:
        print("You may have symptoms that need medical attention.")
    else:
        print("No significant symptoms detected.")

# This will call the main function and start the application.
if __name__ == "__main__":
    main()