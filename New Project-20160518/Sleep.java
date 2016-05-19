import java.util.*;

public class Sleep
{
	
	public  ArrayList<ActivityData> loadData(String dataString)
    {
        ArrayList<ActivityData> data = new ArrayList<>();

        String[] tempData = dataString.split("\n");

        long timeStamp;
        short intensity;
        short steps;
        byte category;
        short heartValue = 0;

        for (int i = 0; i <tempData.length;i++)
        {
            String [] lineTemp = tempData[i].split(";");

            category = Byte.decode(lineTemp[0]);
            intensity = Short.decode(lineTemp[1]);
            steps = Short.decode(lineTemp[2]);
            timeStamp = Long.decode(lineTemp[3]);
            //heartValue = Short.decode(lineTemp[4]);

            data.add(new ActivityData(timeStamp, intensity, steps, category, heartValue));
        }

        return data;
    } 
	
	
	public int getMode(int category, int intensity, int steps, double Distance, double max)
	{
	if (category == 0) {
    if (Distance <= 0) return 0;
    if (Distance > 0) {
        if (Distance <= 4) {
            if (max <= 52) {
                if (intensity <= 21) {
                    if (max <= 27) {
                        if (Distance <= 2) {
                            if (Distance <= 1) {
                                if (intensity <= 0) return 0;
                                if (intensity > 0) {
                                    if (intensity <= 3) {
                                        if (max <= 16) return 0;
                                        if (max > 16) return 1;
                                    }
                                    if (intensity > 3) return 0;
                                }
                            }
                            if (Distance > 1) return 0;
                        }
                        if (Distance > 2) {
                            if (Distance <= 3) {
                                if (max <= 2) return 0;
                                if (max > 2) return 1;
                            }
                            if (Distance > 3) {
                                if (intensity <= 0) return 1;
                                if (intensity > 0) return 0;
                            }
                        }
                    }
                    if (max > 27) {
                        if (max <= 35) return 1;
                        if (max > 35) {
                            if (Distance <= 1) return 0;
                            if (Distance > 1) return 1;
                        }
                    }
                }
                if (intensity > 21) {
                    if (max <= 27) return 0;
                    if (max > 27) {
                        if (max <= 31) {
                            if (max <= 30) {
                                if (intensity <= 27) return 1;
                                if (intensity > 27) {
                                    if (Distance <= 2) return 0;
                                    if (Distance > 2) {
                                        if (Distance <= 3) return 1;
                                        if (Distance > 3) return 0;
                                    }
                                }
                            }
                            if (max > 30) return 1;
                        }
                        if (max > 31) {
                            if (steps <= 5) return 0;
                            if (steps > 5) {
                                if (Distance <= 1) return 1;
                                if (Distance > 1) {
                                    if (max <= 50) {
                                        if (max <= 44) {
                                            if (Distance <= 2) return 0;
                                            if (Distance > 2) return 1;
                                        }
                                        if (max > 44) return 0;
                                    }
                                    if (max > 50) return 1;
                                }
                            }
                        }
                    }
                }
            }
            if (max > 52) {
                if (Distance <= 2) return 0;
                if (Distance > 2) {
                    if (intensity <= 29) {
                        if (max <= 59) return 1;
                        if (max > 59) {
                            if (max <= 67) return 0;
                            if (max > 67) return 1;
                        }
                    }
                    if (intensity > 29) return 0;
                }
            }
        }
        if (Distance > 4) return 0;
    }
}
if (category == 1) {
    if (max <= 73) {
        if (Distance <= 1) return 0;
        if (Distance > 1) return 1;
    }
    if (max > 73) return 0;
}
if (category == 3) return 0;
if (category == 4) {
    if (Distance <= 0) return 0;
    if (Distance > 0) {
        if (max <= 19) return 0;
        if (max > 19) return 1;
    }
}
if (category == 5) {
    if (Distance <= 4) {
        if (Distance <= 3) {
            if (max <= 15) {
                if (max <= 1) return 0;
                if (max > 1) {
                    if (Distance <= 1) return 0;
                    if (Distance > 1) {
                        if (max <= 3) {
                            if (Distance <= 2) {
                                if (intensity <= 2) {
                                    if (intensity <= 0) return 1;
                                    if (intensity > 0) return 0;
                                }
                                if (intensity > 2) return 1;
                            }
                            if (Distance > 2) {
                                if (intensity <= 0) return 0;
                                if (intensity > 0) {
                                    if (intensity <= 1) return 1;
                                    if (intensity > 1) return 0;
                                }
                            }
                        }
                        if (max > 3) return 1;
                    }
                }
            }
            if (max > 15) {
                if (Distance <= 0) {
                    if (intensity <= 2) return 1;
                    if (intensity > 2) {
                        if (intensity <= 12) {
                            if (max <= 40) {
                                if (max <= 24) return 0;
                                if (max > 24) {
                                    if (intensity <= 4) return 1;
                                    if (intensity > 4) return 0;
                                }
                            }
                            if (max > 40) return 0;
                        }
                        if (intensity > 12) {
                            if (max <= 41) return 0;
                            if (max > 41) return 1;
                        }
                    }
                }
                if (Distance > 0) {
                    if (max <= 30) {
                        if (max <= 28) {
                            if (max <= 19) {
                                if (max <= 18) return 1;
                                if (max > 18) return 0;
                            }
                            if (max > 19) return 1;
                        }
                        if (max > 28) {
                            if (intensity <= 12) return 0;
                            if (intensity > 12) return 1;
                        }
                    }
                    if (max > 30) return 1;
                }
            }
        }
        if (Distance > 3) return 1;
    }
    if (Distance > 4) return 0;
}
if (category == 6) return 0;
if (category == 11) {
    if (max <= 20) return 0;
    if (max > 20) {
        if (Distance <= 0) return 0;
        if (Distance > 0) return 1;
    }
}
if (category == 12) return 0;
if (category == 16) return 0;
if (category == 17) return 0;
if (category == 19) return 0;
if (category == 21) return 1;
if (category == 28) return 0;
if (category == 33) return 0;
if (category == 44) return 0;

		
		return 0;
	}
	
}